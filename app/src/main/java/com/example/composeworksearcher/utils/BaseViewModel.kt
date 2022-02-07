package com.example.composeworksearcher.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

abstract class BaseViewModel<Action, UiState>(
    private val scope: CoroutineScope = CoroutineScope(Job() + Dispatchers.Main)
) : ViewModel(), CoroutineScope by scope {

    init {
        /**
         * Subscribe on event from user
         */
        launch {
            subscribeChannel()
        }
    }

    protected abstract val uiBehaviour: MutableStateFlow<UiState>

    private val actionChannel: Channel<Action> = Channel(Channel.UNLIMITED)

    private val eventChannel: Channel<Event> = Channel(Channel.UNLIMITED)

    /**
     * Return flow with event to subscribe in activity
     */
    fun subscribeEvents(): Flow<Event> {
        return eventChannel.consumeAsFlow()
    }

    protected fun sendEvent(event: Event) {
        launch { eventChannel.send(event) }
    }

    /**
     * Collect [Action] from user
     * @param action [Action] object
     */
    protected abstract fun collectAction(action: Action)

    /**
     * Get current [UiState]
     */
    fun getUiState(): StateFlow<UiState> = uiBehaviour.asStateFlow()

    /**
     * Set new [UiState]
     */
    protected fun setUiState(newState: UiState) {
        uiBehaviour.value = newState
    }
    /**
     * Receive [Action] from user
     */
    fun sendAction(action: Action) {
        launch { actionChannel.send(action) }
    }

    private suspend fun subscribeChannel() {
        actionChannel.consumeAsFlow().collect {
            collectAction(it)
        }
    }
}

