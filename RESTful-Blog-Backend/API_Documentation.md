# API Documentation

## Authentication

### Register a User

**Endpoint:** `POST /auth/register`

**Request Body:**

```json
{
    "email": "user@example.com",
    "password": "password123",
    "username": "user1"
}
```

---

## Categories

### Get All Categories

**Endpoint:** `GET /categories`

### Create a Category

**Endpoint:** `POST /categories`

**Request Body:**

```json
{
    "name": "Technology"
}
```

### Get Category by ID

**Endpoint:** `GET /categories/{id}`

---

## Blog Posts

### Get All Blog Posts

**Endpoint:** `GET /blogs`

### Get a Blog Post by ID

**Endpoint:** `GET /blogs/{id}`

### Create a Blog Post

**Endpoint:** `POST /blogs`

**Request Body:**

```json
{
    "title": "New Blog Post",
    "content": "This is the content of the blog post.",
    "author": {"id": 1},
    "category": {"id": 2}
}
```

### Update a Blog Post

**Endpoint:** `PUT /blogs/{id}`

**Request Body:**

```json
{
    "title": "Updated Blog Title",
    "content": "Updated content.",
    "category": {"id": 2}
}
```

### Delete a Blog Post

**Endpoint:** `DELETE /blogs/{id}`

---

## Comments

### Get All Comments

**Endpoint:** `GET /comments`

### Get a Comment by ID

**Endpoint:** `GET /comments/{id}`

### Get All Comments for a Blog Post

**Endpoint:** `GET /comments/post/{postId}`

### Create a Comment

**Endpoint:** `POST /comments`

**Request Body:**

```json
{
   "content": "This is a new comment",
   "author": {"id": 1},
   "blogPost": {"id": 1}
}
```

### Update a Comment

**Endpoint:** `PUT /comments/{id}`

**Request Body:**

```json
{
    "content": "This is the updated comment content."
}
```

