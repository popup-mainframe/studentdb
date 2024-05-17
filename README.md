git init

git add .

git commit -m "comments here"

now create a repo in Github

git remote add origin REMOTE-REPO

git branch -M main

git push origin main

/u/ibmuser/gbwork/studentdb
/usr/lpp/IBM/dbbver2/lib/sclient 127.0.0.1 8080 groovyz  /u/ibmuser/gbwork/studentdb/compilecbl.groovy

**Step 1: compile and BuildReport**

 *with deamon - /usr/lpp/IBM/dbbver2/lib/sclient 127.0.0.1 8080 groovyz /u/ibmuser/gbdir/hellogb1.groovy
 
  *without deamon - /usr/lpp/IBM/dbbver2/bin/groovyz /u/ibmuser/gbdir/hellogb1.groovy
  
**Encoding**

change code tag if requried for manual read Buildreport Json file or any yaml/yml file on uss : chtag -t -c ISO8859-1 <report.json>

To run a new python script,change the encoding of the file using the command   chtag -t -c utf8 hello1.py

python encoding reference chtag -tc IBM-1047 <filenamehello1.py>

https://www.ibm.com/docs/en/python-zos/3.12?topic=getting-started-open-enterprise-sdk-python 

**Step 2: create Package File with BuildReport.json as input**

*Package file creation with the DBB Build report :

python3 /u/ibmuser/gbdir/dbb_prepare_local_folder.py --dbbBuildResult /u/ibmuser/gbdir/hellogb1package/BuildReport.json               --workingFolder /u/ibmuser/gbdir/hellogb1package

**Step 3: To create package.tar file**
Note:BuildReport.json should be available in tje workDir
Run the PackageBuildOutput **without deamon** :-- 
**package tar file without file extension option** 
*/usr/lpp/IBM/dbbver2/bin/groovyz  /u/ibmuser/dbb/Pipeline/PackageBuildOutputs/PackageBuildOutputs.groovy \ --workDir /u/ibmuser/gbdir/hellogb1package

**package tar file with yaml file creaton**
/usr/lpp/IBM/dbbver2/bin/groovyz /u/ibmuser/dbb/Pipeline/PackageBuildOutputs/PackageBuildOutputs.groovy \
      --workDir /u/ibmuser/gbdir/hellogb1package/logs  \
      --addExtension \
      --branch main \
      --generateWaziDeployAppManifest  \
      --includeLogs "*.log"  \
      --versionName rel-1.0.0 \
      --verbose

<<Error in this step>>
*To tar :

tar -cUXf /u/ibmuser/gbdir/hellopackage.tar  /u/ibmuser/gbdir/workpackage

*list contents of tar : tar -tf hellopackage.tar 

*to list with file tags : tar -tf hellopackage.tar -L T

*to untar:

*run simplepackagegroovy

/usr/lpp/IBM/dbbver2/bin/groovyz  /u/ibmuser/dbb/Pipeline/SimplePackageDeploy/SimplePackageDeploy.groovy --workDir /u/ibmuser/gbdir/applout --tarFileName /u/ibmuser/gbdir/workpackage.tar --hlq IBMUSER.UNIT.APPLOUT --packageWithExtension



