package com.example.hello_there.board;

import com.example.hello_there.board.dto.*;
import com.example.hello_there.exception.BaseException;
import com.example.hello_there.exception.BaseResponse;
import com.example.hello_there.login.jwt.JwtProvider;
import com.example.hello_there.login.jwt.JwtService;
import com.example.hello_there.univ.dto.GetUnivScoreRes;
import com.example.hello_there.utils.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    // 생성자 주입 방법을 통해 의존성 주입
    private final BoardService boardService;
    private final JwtService jwtService;
    private final JwtProvider jwtProvider;
    private final UtilService utilService;

    /** 게시글 생성하기 **/
    @PostMapping("/board")
    public BaseResponse<String> createBoard(@RequestPart(value = "image", required = false) List<MultipartFile> multipartFiles,
                                            @Validated @RequestPart(value = "postBoardReq") PostBoardReq postBoardReq) {
        try {
            Long userId = jwtService.getUserIdx();
            return new BaseResponse<>(boardService.createBoard(userId, postBoardReq, multipartFiles));
        }
        catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /** 게시글을 boardId로 조회하기 **/
    @GetMapping("/board/{boardId}")
    public BaseResponse<GetBoardDetailRes> getBoard(@PathVariable Long boardId) {
        try{
            return new BaseResponse<>(boardService.getBoardByBoardId(boardId));
        } catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /** 내 게시글 조회하기 **/
    @GetMapping("/myboard")
    public BaseResponse<Page<GetBoardRes>> getMyBoard() {
        try {
            Long userId = jwtService.getUserIdx();
            Pageable pageable = PageRequest.of(0, 10);
            Page<GetBoardRes> boardPage = boardService.getBoardById(userId, pageable);
            return new BaseResponse<>(boardPage);
        } catch(BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /** 게시글을 멤버Id로 조회하기 **/
    @GetMapping("/board")
    public BaseResponse<Page<GetBoardRes>> getBoards(@RequestParam(required = false) Long userId) {
        try {
            Pageable pageable = PageRequest.of(0, 10);
            if(userId == null) {
                Page<GetBoardRes> boardPage = boardService.getBoards(pageable);
                return new BaseResponse<>(boardPage);
            }
            Page<GetBoardRes> boardPage = boardService.getBoardById(userId, pageable);
            return new BaseResponse<>(boardPage);
        } catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /** 게시글을 Id로 삭제하기 **/
    @DeleteMapping("/board/{board-id}")
    public BaseResponse<String> deleteBoard(@PathVariable(name = "board-id") Long boardId){
        try{
            Long memberId = jwtService.getUserIdx();
            DeleteBoardReq deleteBoardReq = new DeleteBoardReq(memberId, boardId);
            return new BaseResponse<>(boardService.deleteBoard(deleteBoardReq));
        } catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /** 게시글 수정하기 **/
    @PatchMapping("/modify")
    public BaseResponse<String> modifyBoard(@RequestPart(value = "image", required = false) List<MultipartFile> multipartFiles,
                                            @Validated @RequestPart(value = "patchBoardReq") PatchBoardReq patchBoardReq) {
        try {
            Long userId = jwtService.getUserIdx();
            return new BaseResponse<>(boardService.modifyBoard(userId, patchBoardReq, multipartFiles));
        }
        catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}