package com.github.galcyurio.core

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.github.galcyurio.response.*

/**
 * @author galcyurio
 */
final class RawVfiisBinder {

    static ForecastGribResponse fromRawGribResponse(JsonNode rawResponse) {
        ForecastGribResponse response = new ForecastGribResponse()
        bindCommonResponse(response, rawResponse)

        ArrayNode itemArrayNode = rawResponse.get("body").get("items").get("item") as ArrayNode
        itemArrayNode.each {
            it.get("category").asText()
            it.get("obsrValue").asDouble()
        }
        return null
    }

    static ForecastSpaceDataResponse fromRawSpaceDataResponse(JsonNode rawResponse) {
        return null
    }

    static ForecastTimeDataResponse fromRawTimeDataResponse(JsonNode rawResponse) {
        return null
    }

    static ForecastVersionCheckResponse fromRawVersionCheckResponse(JsonNode rawResponse) {
        return null
    }

    static void bindValue(String category, String value) {
        switch (category) {
            case "LGT":
                // TODO: category 바인딩 방법 결정
                // TODO: fcstDateTime 기준으로 30분이든 1시간이든 묶어서 List 형태로 보유한다.
                break
        }
    }

    static void bindCommonResponse(ForecastResponse response, JsonNode rawResponse) {
        JsonNode responseNode = rawResponse.get("response")
        JsonNode headerNode = responseNode.get("header")
        JsonNode bodyNode = responseNode.get("body")
        JsonNode firstItemNode = bodyNode.get("items").get("item").get(0)

        response.with {
            resultCode = headerNode.get("resultCode")
            resultMsg = headerNode.get("resultMsg")
            numOfRows = bodyNode.get("numOfRows").asInt()
            pageNo = bodyNode.get("pageNo").asInt()
            totalCount = bodyNode.get("totalCount").asInt()
            baseDateTime = Date.parse(
                    "yyyyMMddHHmm",
                    firstItemNode.get("baseDate").asInt().toString() + firstItemNode.get("baseTime").asText())

            nx = firstItemNode.get("nx").asInt()
            ny = firstItemNode.get("ny").asInt()
        }
    }
}
