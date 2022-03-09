Feature: Add to watchlist

  In order to add a film into the watch list
  As a valid IMDB User
  I want to Search the film successfully



# Scenario Example
    @Addtowatchlist
    Scenario Outline: Add a Film into the watch list

      Given I log in to IMDB app successfully on Chrome
      And I search a <film> and select
      When I click to add watch list button
      Then I expect to see it in the watch list


      Examples:
        | film         |
        | "fight club" |


