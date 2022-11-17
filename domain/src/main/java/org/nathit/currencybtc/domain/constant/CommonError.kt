package org.nathit.currencybtc.domain.constant

enum class CommonError(val code: String) {
    SUCCESS("00000"),
    GET_DATA_ERROR("10000"),
    DELETE_DATA_ERROR("10001"),
    FILE_INVALID("11001"),
    OUT_OF_STORAGE("11002"),
    FILE_IS_LARGE("11003"),
    USERNAME_PASSWORD_INVALID("20001"),
    FORCE_LOGOUT("20002"),
    FORCE_UPDATE("20003"),
    NO_PERMISSION("30001"),
    UNKNOWN_ERROR("90000");
}