import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract
import org.springframework.cloud.contract.spec.withQueryParameters

contract {
    name = "Query songs by artist"
    description = "Should get a list of songs queried by artist"
    request {
        method = GET
        urlPath = path("/songs") withQueryParameters {
            parameter("artist", value(consumer(anyAlphaNumeric), producer("Rush")))
        }
    }
    response {
        status = OK
        headers {
            contentType = "application/json"
        }
        body = body(
            listOf(
                mapOf(
                    "id" to value(anyUuid),
                    "name" to value(consumer("Xanadu"), producer(anyNonEmptyString)),
                    "artist" to value(consumer("Rush"), producer(anyNonEmptyString))
                )
            )

        )
    }
}
