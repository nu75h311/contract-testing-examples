import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract
import org.springframework.cloud.contract.spec.withQueryParameters

contract {
    name = "Query songs by artist"
    description = "Should get a list of songs queried by artist"
    priority = 1 // This is necessary if query parameters are optional (same urlPath in different contracts)
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
                    "id" to value(consumer("f170b830-0805-4366-9f15-0af7eae60531"), producer(anyUuid)),
                    "name" to value(consumer("Xanadu"), producer(anyNonEmptyString)),
                    "artist" to value(consumer("Rush"), producer(anyNonEmptyString)),
                    "duration" to value(consumer("11:04"), producer(anyTime))
                )
            )

        )
    }
}
