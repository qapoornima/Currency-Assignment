Feature: Filtering UI
@Assignment
Scenario: Filtering UI and extracting data for comparison    
Given  user launching the coin market application 
When   user displaying the content by 20 row
Then   user caputre the required page content
When   user set the filter on the page by Algorith PoW
And    user applying the  filter with Mineable,Coins and price range
Then   user capture the filtered content names and compare with the previous content name