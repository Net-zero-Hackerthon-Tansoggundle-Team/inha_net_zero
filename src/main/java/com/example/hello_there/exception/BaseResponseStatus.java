package com.example.hello_there.exception;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_JWT(false, 2001, "JWT를 입력해주세요"),
    INVALID_JWT(false, 2002, "유효하지 않은 JWT에요"),
    INVALID_USER_JWT(false,2003,"권한이 없는 유저의 접근입니다."),
    NONE_EXIST_USER(false, 2006, "존재하지 않는 사용자에요"),
    // users
    USERS_EMPTY_USER_ID(false, 2010, "유저 아이디 값을 확인해주세요."),
    INVALID_MEMBER_ID(false, 2010, "멤버 아이디와 이메일이 일치하지 않습니다."),
    PASSWORD_CANNOT_BE_NULL(false, 2011, "비밀번호를 입력해주세요."),
    // [POST] /users
    POST_USERS_EMPTY_EMAIL(false, 2015, "이메일을 입력해주세요."),
    POST_USERS_INVALID_EMAIL(false, 2016, "올바른 이메일 형식이 아니에요"),
    POST_USERS_EXISTS_EMAIL(false,2017,"중복된 이메일이에요"),
    POST_USERS_NONE_EXISTS_EMAIL(false,2018,"등록되지 않은 이메일이에요"),
    LOG_OUT_USER(false,2019,"이미 로그아웃된 유저에요"),

    // [POST] /boards
    POST_BOARDS_EMPTY_TITLE(false, 2019, "제목은 두 글자 이상으로 작성해주세요."),
    INVALID_INPUT(false, 2020, "유효하지 않은 입력입니다."),
    FAIL_TO_LOAD(false, 2021, "게시글을 불러오는데 실패했어요"),


    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    // [POST] /users
    DUPLICATED_EMAIL(false, 3013, "중복된 이메일입니다."),
    FAILED_TO_LOGIN(false,3014,"비밀번호가 틀렸습니다."),
    FAILED_TO_LOGOUT(false, 3015, "로그아웃에 실패하였습니다"),
    MEMBER_NOT_FOUND(false, 3016, "등록된 이메일이 아닙니다."),
    INCORRECT_PASSWORD(false, 3017, "비밀번호가 틀렸어요"),
    PASSWORD_NOT_SAME(false, 3018, "패스워드가 달라요"),
    PASSWORD_LENGTH_INVALID(false, 3019, "패스워드 조건을 확인해주세요 (8 ~ 12글자 사이)"),

    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),

    //[PATCH] /users/{userIdx}
    MODIFY_FAIL_USERNAME(false,4014,"유저네임 수정에 실패하였습니다"),

    //[PATCH] /users/{boardIdx}
    MODIFY_FAIL_BOARD_TITLE(false, 4015, "게시글 제목 수정에 실패하였습니다"),

    DELETE_FAIL_USER(false, 4016, "멤버 삭제에 실패하였습니다."),
    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다."),


    /**
     *   5000 : Board 관련 오류
     */
    NONE_EXIST_BOARD(false, 5000, "요청하신 게시글은 존재하지 않아요"),
    INVALID_BOARD_ID(false, 5001, "유효하지 않은 입력입니다."),
    EXCEEDED_TITLE_LIMIT(false, 5002, "제목이 글자수 제한을 초과하였습니다."),
    EXCEEDED_CONTENT_LIMIT(false, 5003, "본문이 글자수 제한을 초과하였습니다."),
    BOARD_NOT_FOUND(false, 5004, "요청하신 제목의 게시글은 존재하지 않습니다."),
    SAME_TITLE_ERROR(false, 5005, "동일한 게시글이 2개 이상 존재해 수정을 진행할 수 없습니다."),
    CANNOT_DELETE(false, 5006, "작성된 게시글이 존재하여 멤버를 삭제할 수 없어요"),
    MEMBER_WITHOUT_PERMISSION(false, 5007, "본인의 게시글에 대해서만 수정 및 삭제가 가능해요."),

    /**
     *   6000 : 회원등록 관련 오류
     */
    NICKNAME_ERROR(false, 6000, "이미 존재하는 닉네임이에요."),
    KAKAO_ERROR(false, 6001, "카카오 로그아웃에 실패했습니다."),
    INTRODUCE_ERROR(false, 6002, "한줄 소개는 0~30자이어야 합니다."),
    DISAGREE_TO_PROVIDE(false, 6003, "정보 제공에 동의해주세요."),
    ALREADY_LOGIN(false, 6004, "이미 로그인된 유저입니다."),
    NONE_EXIST_UNIV(false, 6005, "대학교 등록을 먼저 진행해주세요"),
    ALREADY_EXIST_UNIV(false, 6006, "이미 등록된 대학교에요"),

    /**
     *   7000 : 댓글 관련 오류
     */
    NONE_EXIST_COMMENT(false, 7000, "요청하신 댓글은 존재하지 않습니다."),

    /**
     *   8000 : 토큰 관련 오류
     */
    EXPIRED_USER_JWT(false,8000,"만료된 JWT입니다."),
    REISSUE_TOKEN(false, 8001, "토큰이 만료되었습니다. 다시 로그인해주세요."),
    FAILED_TO_UPDATE(false, 8002, "토큰을 만료시키는 작업에 실패하였습니다."),
    FAILED_TO_REFRESH(false, 8003, "토큰 재발급에 실패하였습니다."),

    /**
     *   9000 : 채팅 관련 오류
     */
    CANNOT_CREATE_ROOM(false, 9000, "혼자만의 채팅방은 만들 수 없습니다."),
    ALREADY_EXIST_MEMBER(false, 9001, "이미 추가된 유저입니다."),
    FAILED_TO_ENTER(false, 9002, "채팅방 입장에 실패하였습니다."),
    NONE_EXIST_ROOM(false, 9003, "요청하신 채팅방은 존재하지 않습니다."),
    OVER_CAPACITY(false, 9004, "채팅방에서 지정한 최대 인원 수에 도달하여 추가할 수 없습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
