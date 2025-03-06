# API Documentation

---

## Authentication Endpoint

### 1. Register a User

**POST:** ` http://localhost:8080/auth/register`

**Request Body:**

```json
{
    "email": "user@example.com",
    "password": "password123",
    "username": "user1"
}
```
---
### 2. View All Users
**GET** `http://localhost:8080/auth/users`

### 3. View User by ID
**GET** `http://localhost:8080/auth/users/{id}`

### 4. Delete a User by ID
**DELETE** `http://localhost:8080/auth/users/{id}`

---
## Categories Endpoint

### 1. Get All Categories

**GET:** ` /categories`

### 2. Create a Category

**POST:** ` /categories`

**Request Body:**

```json
{
    "name": "Technology"
}
```

###3. Get Category by ID

**GET:** ` /categories/{id}`

---

## Blog Posts Endpoints

### 1. Get All Blog Posts

**GET:** ` /blogs`

### 2. Get a Blog Post by ID

**GET:** ` /blogs/{id}`

### 3. Create a Blog Post

**POST:** ` /blogs`

**Request Body:**

```json
{
    "title": "New Blog Post",
    "content": "This is the content of the blog post.",
    "author": {"id": 1},
    "category": {"id": 2}
}
```

### 4. Update a Blog Post

**PUT:** ` /blogs/{id}`

**Request Body:**

```json
{
    "title": "Updated Blog Title",
    "content": "Updated content.",
    "category": {"id": 2}
}
```

### 5. Delete a Blog Post

**Endpoint:** `DELETE /blogs/{id}`

---

## Comments Endpoint

### 1. Get All Comments

**GET:** ` /comments`

###  2.Get a Comment by ID

**GET:** ` /comments/{id}`

### 3. Get All Comments for a Blog Post

**GET:** ` /comments/post/{postId}`

### 4. Create a Comment

**POST:** ` /comments`

**Request Body:**

```json
{
   "content": "This is a new comment",
   "author": {"id": 1},
   "blogPost": {"id": 1}
}
```

### 5. Update a Comment

**PUT:** ` /comments/{id}`

**Request Body:**

```json
{
    "content": "This is the updated comment content."
}
```

