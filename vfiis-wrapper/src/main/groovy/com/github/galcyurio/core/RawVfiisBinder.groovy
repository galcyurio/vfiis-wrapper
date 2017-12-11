package com.github.galcyurio.core

import com.fasterxml.jackson.databind.JsonNode
import com.github.galcyurio.response.*
/**
 * @author galcyurio
 */
final class RawVfiisBinder {

    static ForecastGribResponse fromRawGribResponse(JsonNode rawResponse) {
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
        }
    }
}
