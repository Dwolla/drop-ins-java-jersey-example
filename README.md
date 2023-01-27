# Dwolla Drop-Ins Java Jersey Example

This repository deploys a small Java Jersey REST API that is responsible for responding to [Dwolla's drop-in components library](https://developers.dwolla.com/concepts/drop-in-components) client token request. Once this project is running, you can call it via the [`token` or `tokenUrl`](https://developers.dwolla.com/api-reference/drop-in-components/create-client-token#client-token-usage) property.

> **NOTE**: This project was built with and tested using Gradle 7.6 and OpenJDK 19.

## Getting Started

1. Clone the repository to your local machine
2. Change the [Dwolla SDK API key and secret](https://github.com/Dwolla/drop-ins-jersey-client-token-example/blob/main/src/main/java/com/dwolla/dropintoken/ClientTokenResource.java#L21-L25) to use your [Sandbox API credentials](https://dashboard-sandbox.dwolla.com/applications-legacy).
3. Modify the [`Access-Control-Allow-Origin`](https://github.com/Dwolla/drop-ins-jersey-client-token-example/blob/main/src/main/java/com/dwolla/dropintoken/CORSResponseFilter.java) header to include the URL of the environment that contains Dwolla's drop-in components library.
4. Run the project and begin using Dwolla's drop-in components library!
