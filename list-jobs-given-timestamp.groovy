// Listar jobs por tiempo
String df = 'MMM dd, yyyy h:mm a'

long startTimestamp = Date.parse(df, 'Apr 27, 2020 1:20 PM').getTime()
long endTimestamp = Date.parse(df, 'Apr 27, 2020 2:30 PM').getTime()

for (job in Jenkins.instance.getAllItems(Job.class)) {
  builds = job.getBuilds().byTimestamp(startTimestamp, endTimestamp)
  if(!builds.isEmpty()) {
    println 'Job Full Name: ' + job.fullName + ' \n' + 'Builds ' + builds + '\n'
  }
}

return null