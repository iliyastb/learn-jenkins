pipeline {
//  agent any

//  agent {
//    node { label "workstation" }
//  }

  agent {
    label "terraform"
  }

  environment {
    SAMPLE_URL = "google.com"
    SSH = credentials("ssh")
  }

  parameters {
    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
  }

  stages {
    stage("one") {
      steps {
        echo "one"
        sh "env"
      }
    }

    stage("two") {
      when {
        environment name: 'PERSON', value: 'ILIYAS'
      }
      input {
        message "Should we continue?"
        ok "Yes, we should."
      }
      steps {
        echo "two"
      }
    }
  }

  post {
    always {
      echo 'Hello again!'
    }
  }
}