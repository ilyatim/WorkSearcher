package com.example.composeworksearcher.data

data class Vacancy(
    val vacancyId: String,
    val info: BaseVacancyInfo,
    val userInfo: BaseUserInfo
) {
    constructor(
        vacancyId: String,
        vacancyName: String,
        salaryMin: Int,
        salaryTop: Int,
        publishDate: Long,
        city: String,
        employer: String,
        isTrustworthy: Boolean,
        description: String,
        isFavorite: Boolean,
        isResponded: Boolean,
    ) : this(
        vacancyId,
        BaseVacancyInfo(
            vacancyName,
            salaryMin,
            salaryTop,
            publishDate,
            city,
            employer,
            isTrustworthy,
            description
        ),
        BaseUserInfo(
            isFavorite,
            isResponded
        )
    )
}

data class BaseVacancyInfo(
    val vacancyName: String,
    val salaryMin: Int,
    val salaryTop: Int,
    val publishDate: Long,
    val city: String,
    val employer: String,
    val isTrustworthy: Boolean,
    val description: String,
)

data class BaseUserInfo(
    val isFavorite: Boolean,
    val isResponded: Boolean,
)