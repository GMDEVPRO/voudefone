```mermaid

classDiagram
    class User {
        +string user
        +login()
        +logout()
    }

    class Account {
        +string email
        +string password
        +User user
        +Authentication authentication
        +List~TaskList~ taskLists
    }

    class Authentication {
        +int logged_in_user
        +bool authenticated
        +authenticate()
        +deauthenticate()
    }

    class TaskList {
        +List~Task~ tasks
        +addTask()
        +removeTask()
    }

    class Task {
        +int task_id
        +string title
        +string description
        +DateTime due_date
        +string status
        +editTask()
        +deleteTask()
    }

    User "1" -- "1" Account : has
    Account "1" -- "1" Authentication : contains
    Account "1" -- "0..*" TaskList : contains
    TaskList "1" -- "0..*" Task : contains



