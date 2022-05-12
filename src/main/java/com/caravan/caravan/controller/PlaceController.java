package com.caravan.caravan.controller;

import com.caravan.caravan.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService service;

}
