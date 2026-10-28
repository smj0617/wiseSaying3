package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {

    public static final Scanner sc = new Scanner(System.in);
    public static final WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public static final WiseSayingService wiseSayingService = new WiseSayingService(wiseSayingRepository);
    public static final WiseSayingController wiseSayingController = new WiseSayingController(sc, wiseSayingService);
    public static final SystemController systemController = new SystemController();
}
