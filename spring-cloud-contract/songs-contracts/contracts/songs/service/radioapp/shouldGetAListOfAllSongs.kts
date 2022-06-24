import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "GET all songs"
    description = "Should get a list of all songs"
    request {
        url = url("/songs")
        method = GET
    }
    response {
        status = OK
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