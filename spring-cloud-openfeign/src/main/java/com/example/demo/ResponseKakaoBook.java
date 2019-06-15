package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseKakaoBook implements Serializable {

    private ResponseKakaoBook.Meta meta;
    private List<document> documents;

    public List<document> getDocuments() {
        return documents;
    }

    @Data
    @NoArgsConstructor
    public static class Meta{
        long total_count;
        long pageable_count;
        Boolean is_end;
    }

    @Data
    @NoArgsConstructor
    public static class document{
        String title;
        String contents;
        String url;
        List<String> authors;
        String publisher;
        String thumbnail;
        //TODO: 더 많은 데이터
    }

}
