# AutoLoc - Security Notes

## 1. Authentication and Authorization

Authentication verifies the user's identity.

Authorization determines which resources the user
is allowed to access.

## 2. Security Configuration

The application uses Spring Security with HTTP Basic
authentication.

Two users are configured in memory:

- student: ROLE_USER
- admin: ROLE_ADMIN

## 3. Endpoint Access Rules

| Endpoint | Anonymous | USER | ADMIN |
|---|---|---|---|
| /api/public/ping | 200 | 200 | 200 |
| /api/hello | 401 | 200 | 200 |
| /api/admin/report | 401 | 403 | 200 |

The /api/admin/** rule must appear before /api/**
because Spring Security evaluates authorization
rules in order.

## 4. HTTP Status Codes

200 OK:
The request was successful.

401 Unauthorized:
The user is not authenticated.

403 Forbidden:
The user is authenticated but does not have
permission to access the resource.

## 5. Password Security

Passwords are encoded using BCrypt instead of being
stored as plain text.

BCrypt uses salted, one-way password hashing.

## 6. In-Memory Users

In-memory users are useful for testing and learning.

They are not suitable for production because users
and roles are hardcoded and cannot be managed easily.

For production, users and roles could be stored
in MySQL and loaded through a UserDetailsService.

## 7. Monitoring Security

The health and Prometheus endpoints are accessible
without authentication for this local exercise.

In production, these endpoints should be protected.
