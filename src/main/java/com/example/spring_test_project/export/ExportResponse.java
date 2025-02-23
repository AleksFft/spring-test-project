/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.export;

import lombok.Value;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
@Value(staticConstructor = "of")
public class ExportResponse {

    private static final String ATTACHMENT_FILENAME = "attachment; filename*=\"UTF-8'ru-ru'";
    private static final String SESSION_ID = "Session-Id";

    /**
     * Имя файла.
     */
    String fileName;

    /**
     * Содержимое файла.
     */
    byte[] data;

    /**
     * Идентификатор сессии.
     */
    String sessionId;

    /**
     * Возвращает результат REST-запроса.
     *
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<byte[]> responseEntity() {
        var headers = new HttpHeaders();
        headers.setAccessControlExposeHeaders(List.of(HttpHeaders.CONTENT_DISPOSITION));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, contentDisposition(fileName));
        headers.set(HttpHeaders.CONTENT_TYPE, contentType(fileName));
        headers.set(SESSION_ID, sessionId);
        return ResponseEntity.ok()
                .headers(headers)
                .body(data);
    }

    /**
     * Формирует имя файла для получения браузером в заголовке ответа HTTP.
     *
     * <p>
     * По умолчанию заголовки HTTP кодируются в US-ASCII и не поддерживают кириллицу.
     * См. <a href="http://www.faqs.org/rfcs/rfc2231.html">RFC 2231</a>.
     * </p>
     *
     * @param fileName file name
     * @return string by pattern: attachment; filename*="encoding + 'ru-ru' + url encoded file name"
     */
    private String contentDisposition(String fileName) {
        return ATTACHMENT_FILENAME + URLEncoder.encode(fileName, StandardCharsets.UTF_8)+ "\"";
    }

    private String contentType(String fileName) {
        switch (FilenameUtils.getExtension(fileName)) {
            case "txt":
            case "csv":
                return MediaType.TEXT_PLAIN_VALUE;
            case "json":
                return MediaType.APPLICATION_JSON_VALUE;
            case "xml":
                return MediaType.APPLICATION_XML_VALUE;
            case "pdf":
                return MediaType.APPLICATION_PDF_VALUE;
            case "zip":
                return "application/zip";
            default:
                return MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
    }
}
