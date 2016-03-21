# Mini-twitter

Make an iOS or android app.
You can use any frameworks or languages.

## 1. Login
Login handled by [auth0](https://auth0.com/)
Save user's JWT token in app.

## 2. Ask Users for API endpoint URL
Save this endpoint URL in app.
Example: `https://www.example.com/tweets/`

Example: If endpoint URL is `https://www.example.com/tweets/`

## 3. All tweets
Show all tweets returned by backend server.
API endpoint `GET https://www.example.com/tweets/`

- Handle tweets refresh

JSON Example: `GET https://www.example.com/tweets/`

```
{
  "data": [
    {
      "id": "f808d40b-4c54-4824-b3e0-8217e0840067",
      "type": "tweets",
      "attributes": {
        "author": "Tang Rufus",
        "body": "Hi all",
        "created-at": "2015-02-17T01:28:32.402Z"
      }
    },
    {
      "id": "d17154e6-b41a-4e8c-9ee9-131eb756cf69",
      "type": "tweets",
      "attributes": {
        "author": "Jonathon Sze",
        "body": "Hi rufus",
        "created-at": "2015-03-17T01:28:32.402Z"
      }
    },
    {
      "id": "9592a02f-8469-4f17-9146-3575ddab9365",
      "type": "tweets",
      "attributes": {
        "author": "Tang Rufus",
        "body": "bye bye",
        "created-at": "2015-04-17T01:28:32.402Z"
      }
    },
    {
      "id": "c6fd6e46-9a3e-442c-a3fd-13abae2f45ae",
      "type": "tweets",
      "attributes": {
        "author": "Tang Rufus",
        "body": "Let's play a game",
        "created-at": "2016-03-17T01:28:32.402Z"
      }
    }
  ]
}
```

## 4. Make a tweet
Create a tweet.
API endpoint `CREATE https://www.example.com/tweets/`

- follows [jsonapi.org](http://jsonapi.org/) standard
- handle errors

Error example:

```
HTTP/1.1 422 Unprocessable Entity

{
  "errors": [
    {
      "source": {
        "pointer": "/data/attributes/body"
      },
      "detail": "Some error message server returns. Show this message to user"
    }
  ]
}
```

## 5. Logout
Clear user jwt & endpoint URL

# Authentication

Use [auth0](https://auth0.com).
Use Facebook connect only.
Use auth0's JWT access token (sometimes called id_token). Refresh token is not required.

Create your own auth0 account (free plan) and Facebook app.

When making API calls, put the JWT token in header:
`Authorization: bearer {ACCESS-TOKEN}`

For 401 and 403 errors, server returns headers only, no content.

# API Backend

You *don't* have to implement this api server.

Your app needs to ask users for API endpoint URL.
Example: `https://www.example.com/tweets/`

This API is RESTful.

This server follows most of [jsonapi.org](http://jsonapi.org/) standard.

This server responses to `HTTP GET` and `HTTP CREATE` only.

No pagination.

Limitation:
This server use Ruby on Rails with active model serializers gem.
AMS doesn't implement all jsonapi.org specification yet.
https://github.com/rails-api/active_model_serializers/tree/master/docs/jsonapi

For 401, 403 and 5xx errors, server returns headers only, no content.

Timeouts in 30 seconds.  
