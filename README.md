## General Project Structure

```bash
├─┬ src/main/
│ ├─┬ java/com/hli/p3/nms/
│ │ ├─ aspect/                                  # Directory for AOP configure (Advice + Pointcut)
│ │ ├─ config/                                  # Directory for Spring Boot Configures
│ │ ├─ constants/                               # Directory for Constants variables
│ │ ├─ exception/                               # Directory for exception based AOP
│ │ ├─ interceptor/                             # Directory for interceptors(session, correlation)
│ │ ├─ model/                                   # Directory for data model
│ │ ├─ repository/                              # Directory for repositories
│ │ ├─ restcontroller/                          # Directory for restcontrollers
│ │ ├─ service/                                 # Directory for services
│ │ ├─ utility/                                 # Directory for java utilites
│ │ └─ ConventionApplication                    # Spring Boot Application file
│ └─┬ resources/                                # Directory for static resources
│   ├─┬ db/                                     # Directory for DB Scheme management
│   │ ├─ erd/                                   # Directory for ERD file using MySQL Workbench
│   │ └─ migration/                             # Directory for Flyway db migration
│   ├─ sql/                                     # Directory for sql files
│   └─ application.yml                          # Spring boot configure file
├─ .gitlab-ci.yml                               # git lab ci file link
├─ build.gradle                                 # gradle build file
├─ docker-compose.yaml                          # Local MySQL, Redis Container
├─ Docker-entrypoint.sh                         # docker build sh in CICD
└─ Dockerfile                                   # docker build sh in CICD
```
## Source management
- gitlab: https://gitlab.lotte.vn/

### Branch management
- feature/develop/stage/master default branch
- feature branch will be created from develop branch when making for issue
- bugfix branch before reflection , hotfix branch after reflection
- naming rule -> (master|stage|develop|develop2|(revert|cherry-pick)-[a-z0-9_/]+|[0-9]+-(issue|feature|feature2|bugfix|hotfix) -[-a-z0-9_/]+)
- ex: issue[number]-feature-[issue title], 103-feature-member-login

### API Doc
- Swagger

### DB Information

- /etc/secret/TSMS_ENDPOINT : db endpoint ex) localhost:3306
- /etc/secret/TSMS_USERNAME : db user name
- /etc/secret/TSMS_PASSWORD : db user password
- /etc/secret/REDIS_ENDPOINT : redis endpoint ex) localhost
- For windows, it is located under C:\etc\secret\

## Code Conventions
https://www.oracle.com/technetwork/java/codeconventions-150003.pdf


