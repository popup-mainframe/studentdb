git init

git add .

git commit -m "comments here"

now create a repo in Github
git remote add origin REMOTE-REPO

git branch -M main

git push origin main

/u/ibmuser/gbwork/studentdb

/usr/lpp/IBM/dbbver2/lib/sclient 127.0.0.1 8080 groovyz  /u/ibmuser/gbwork/studentdb/compilecbl.groovy

 /usr/lpp/IBM/dbbver2/lib/sclient 127.0.0.1 8080 groovyz /u/ibmuser/gbdir/hellogb1.groovy
without deamon - /usr/lpp/IBM/dbbver2/bin/groovyz /u/ibmuser/gbdir/hellogb1.groovy


/us/ibmuser/gbdir/Package.groovy    
/usr/lpp/IBM/dbbver2/bin/groovyz /u/ibmuser/gbdir/Package.groovy

read Buildreport Json file on uss : chtag -t -c ISO8859-1 <report.json>

To run a new python script,change the encoding of the file using the command   chtag -t -c utf8 hello1.py


python encoding reference chtag -tc IBM-1047 <filenamehello1.py>
https://www.ibm.com/docs/en/python-zos/3.12?topic=getting-started-open-enterprise-sdk-python 


*Package file creation with the DBB Build report :
python3 /u/ibmuser/gbdir/dbb_prepare_local_folder.py --dbbBuildResult /u/ibmuser/gbdir/BuildReport.json               --workingFolder /u/ibmuser/gbdir/workpackage

*To tar :
tar -cUXf /u/ibmuser/gbdir/hellopackage.tar  /u/ibmuser/gbdir/workpackage
*list contents of tar : tar -tf hellopackage.tar 
*to lost with file tags : tar -tf hellopackage.tar -L T
*to untar:

*run simplepackagegroovy
/usr/lpp/IBM/dbbver2/bin/groovyz  /u/ibmuser/dbb/Pipeline/SimplePackageDeploy/SimplePackageDeploy.groovy --workDir /u/ibmuser/gbdir/applout --tarFileName /u/ibmuser/gbdir/workpackage.tar --hlq IBMUSER.UNIT.APPLOUT --packageWithExtension


