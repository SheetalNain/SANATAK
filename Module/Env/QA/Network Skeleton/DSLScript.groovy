folder('Env') {
    description("This folder contains all environment-related jobs")
    displayName("Env")
}

folder('Env/QA') {
    description("This folder contains jobs for the Development environment")
    displayName("QA")
}

folder('Env/QA/Network Skeleton') {
    description("Infrastructure-related jobs for the Development environment")
    displayName("Network Skeleton")
}

folder('Env/QA/Network Skeleton') {
    description("Terraform application jobs under Infrastructure for Development")
    displayName("Network Skeleton")
}

pipelineJob('Env/QA/Network Skeleton') {
    description("CI pipeline for Network Skeleton")
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/snaatak-Zero-Downtime-Crew/jenkins.git')
                        credentials('git-cred')
                    }
                    branches('*/Sheetal-SCRUM-373')
                }
            }
            scriptPath('Wrapper Code/Env/QA/Network Skeleton/Jenkinsfile')         }
    }
}
