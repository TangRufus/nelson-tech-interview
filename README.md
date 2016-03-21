# Mini-twitter

Make an iOS or android app.

Unless specified, make your own decisions. If it is important, tell us during submission.

## 1. Login

Login handled by [auth0](https://auth0.com/) (See Authentication)

Use Facebook connect only.

- Save user's access token (JWT) in app.

## 2. Ask Users for API endpoint URL

- Save this endpoint URL in app.

Example: `https://www.example.com/tweets/`

## 3. All tweets

- Show all tweets returned by backend server, in chronological order
- Handle tweets refresh

API endpoint `GET https://www.example.com/tweets/`

Example:

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

## 4. Create a tweet

- Follows [jsonapi.org](http://jsonapi.org/) standard
- Handle errors
  * For 422 errors, show server returned messages to users.
  * For 401, 403 and 5xx errors, server returns headers only (no content). You have to show something meaningful to users.

API Endpoint: `CREATE https://www.example.com/tweets/`

Error 422 example:

```
HTTP/1.1 422 Unprocessable Entity

{
  "errors": [
    {
      "source": {
        "pointer": "/data/attributes/body"
      },
      "detail": "too long. Must less than 140 characters"
    }
  ]
}
```

## 5. Logout

- Clear saved user JWT
- Clear saved endpoint URL

# Authentication

Use [auth0](https://auth0.com).

Use Facebook connect only.

Use auth0's JWT access token (sometimes called `id_token`). Refresh token is not required.

Create your own auth0 account (**free plan**) and Facebook app.

# API Backend

You **don't** have to implement this API server.

Your app needs to ask users for API endpoint URL.
Example: `https://www.example.com/tweets/`

This API backend:

- is RESTful
- follows most of [jsonapi.org](http://jsonapi.org/) standard (see limitations)
- responses to `HTTP GET` and `HTTP CREATE` only
- requires bearer tokens (users' Auth0 JWT tokens) in header:
  * e.g: `Authorization: bearer {ACCESS-TOKEN}`
- no pagination

## Limitations

This server use Ruby on Rails with active model serializers (AMS) gem.

AMS doesn't implement all jsonapi.org specification yet.
Read: https://github.com/rails-api/active_model_serializers/tree/master/docs/jsonapi

For 401, 403 and 5xx errors, server returns headers only, no content.

Timeouts in 30 seconds.  

# Submission

- Source code
- APK file if android app
- Auth0 client id
- Auth0 client secret
- Example payload of:
  * Create a tweet
- Important decisions made

Make pull request to this repo

Deadline: Ask Jonathon

Late submission not accepted (github timestamp)

# Common Mistakes

- Public users can't login via Facebook
  * Make sure your Facebook app has **gone live**
- Show `Unknown Errors` to user
  * React to errors
- `Loading...` forever
  * Set timeouts to all API calls
