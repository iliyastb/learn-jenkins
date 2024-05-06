node("workstation") {

  properties([
    parameters([
      string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?'),
    ])
  ])

  env.SAMPLE_URL = "google.com"

  try {
    withCredentials([usernameColonPassword(credentialsId: "ssh", variable: "USERPASS")]) {
      stage("one") {
        echo "one"
        sh "env"
        sh "env >/tmp/env"
      }
    }

    if ( PERSON == "ILIYAS") {
      stage("two") {
        echo "two"
      }
    }

    stage("three") {
      stage('Deploy') {
        input(id: 'deploy_approval', message: 'Approve deployment?', ok: 'Deploy', reject: 'Cancel')
      }
    }

    stage("four") {
      echo "four"
      sh 'exit 1'
    }

  } catch (e) {
    stage("Declarative: post actions") {
      echo "This will run only if failed"
    }
  }
}