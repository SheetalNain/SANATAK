folder('Module') {
    displayName('Module')
}

folder('Module/Env') {
    displayName('Env')
}

folder('Module/Env/QA') {
    displayName('QA')
}

folder('Module/Env/QA/Wrapper-Code') {
    displayName('Wrapper-Code')
}

folder('Module/Env/QA/Wrapper-Code/Network-Skeleton') {
    displayName('Network-Skeleton')
}

pipelineJob('Module/Env/QA/Wrapper-Code/Network-Skeleton') {
    displayName('Network Skeleton')
    description('Job to wrapper code for Network Skeleton from GitHub repository')

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/snaatak-Zero-Downtime-Crew/Wrapper-Code.git')
                        credentials('git-cred')
                    }
                    branch('*/Sheetal-SCRUM-373')
                }
            }
            scriptPath('Env/QA/Network-Skeleton/Jenkinsfile')
        }
    }
}
