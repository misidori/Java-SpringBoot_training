package com.ticketone.ticketone.utils;

import org.springframework.data.domain.PageRequest;

public class UtilsTicketone {
    public static PageRequest createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }

}
