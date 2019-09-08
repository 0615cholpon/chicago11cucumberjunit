$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/etsySearch.feature");
formatter.feature({
  "name": "Etsy search feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Etsy title verification using search feature",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@etsy"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Etsy Homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "Etsy_Steps.user_is_on_Etsy_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User types \"Wooden Spoon\" in the search box",
  "keyword": "When "
});
formatter.match({
  "location": "Etsy_Steps.user_types_in_the_search_box(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks search button",
  "keyword": "And "
});
formatter.match({
  "location": "Etsy_Steps.user_clicks_search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});