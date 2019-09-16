# CI/CD Proposal

## Code Versioning
The development of a new feature must be done following the [Gitflow Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow).

There will be a `develop` branch that is created from `master`. All the features branches created by the developers must be created from `develop` branch. When a feature is completed the developer may merge the feature branch to the develop branch. All conflicts must be resolved before merge the feature branch to `develop` branch.
The `master` branch must always be ready for the production deployment.

## CI/CD Pipeline

### Development Pipeline
When a developer creates a Pull Request from a feature branch to `develop` a CI pipeline will start, for example Jenkins, it will execute all the tests in the repository to guarantee that the new feature did not break any other that is currently in `develop`. If the any of the tests fail the Pull Request is not allowed to be merge notifying the developers about the problem.

When the tests run successfully and the build is done, a code quality program will check the code, for example SonarQube, these will check if the code have good cooverage in tests and if there is any security problem with the same. If the code have less than 80% of cooverage in tests or there is a total of 10 problems these stage will fail, sending a nootification to the team about the problem.

After passing the criteria of control quality, the Pull Request must be review and approved by at least 50% of the team to ensure the best practices and identify possible issues in the code.

After the Pull Request is approved the next phase is to merge and build a new docker image of the application. These image is build it will be deploy into test or QA environment to be tested furthermore to ensure the application does not have any broken feature.

### Production Pipeline
`Master` branch is the one used to test and build of production version of the application.

When realeasing a new version of the application the `develop` branch will be merge into `master` branch. At these event a tag version must be create, marking a new version of the application and also a rollback point. This merge will trigger the CI pipeline to run all the tests, build the images and upload them for an internal docker registry to be deployed.