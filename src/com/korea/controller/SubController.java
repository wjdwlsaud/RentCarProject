package com.korea.controller;

import com.korea.dto.DTO;
import com.korea.view.SuperViewer;

public interface SubController
{
    boolean execute(int num, DTO dto, SuperViewer view);
}
