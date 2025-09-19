package khj.boot.controller;


import khj.boot.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("board")
public class BoardController {
    @Autowired
    private BoardService boardService;
}
