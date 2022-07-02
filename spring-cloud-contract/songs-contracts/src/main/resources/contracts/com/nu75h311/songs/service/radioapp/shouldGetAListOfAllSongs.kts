import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "Request all songs"
    description = "Should get a list of all songs"
    request {
        method = GET
        urlPath = path("/songs")
    }
    response {
        status = OK
        headers {
            contentType = "application/json"
        }
        body = body(
            listOf(
                mapOf(
                    "id" to value(consumer("37808461-ca2c-47ee-849f-7367170efd25"), producer(anyUuid)),
                    "name" to value(consumer("Sliver"), producer(anyNonEmptyString)),
                    "artist" to value(consumer("Nirvana"), producer(anyNonEmptyString))
                ),
                mapOf(
                    "id" to value(consumer("f170b830-0805-4366-9f15-0af7eae60531"), producer(anyUuid)),
                    "name" to value(consumer("Xanadu"), producer(anyNonEmptyString)),
                    "artist" to value(consumer("Rush"), producer(anyNonEmptyString))
                )
            )

        )
    }
}
