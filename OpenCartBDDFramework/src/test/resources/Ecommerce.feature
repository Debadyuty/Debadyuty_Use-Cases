Feature: OpenCart E-Commerce Flow

Scenario Outline: Complete E-Commerce Flow

Given user launches application

When user login using excel data

And user searches "<product>"

And user adds product to cart

Then user validates cart

Examples:
| product |
| iPhone |