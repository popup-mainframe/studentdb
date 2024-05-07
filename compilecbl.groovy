import com.ibm.dbb.build.*

println("Build report included . . .")
BuildReportFactory.createDefaultReport()

println("Copying source from zFS to PDS . . .")
def copy = new CopyToPDS().file(new File("/u/ibmuser/gbdir/hellogb.cbl")).dataset("GOMATHI.DBB.COBOL").member("hellogb").output(true).key(file).execute()

println("Compiling . . .")
def compile = new MVSExec().pgm("IGYCRCTL").parm("LIB")
compile.dd(new DDStatement().name("SYSIN").dsn("GOMATHI.DBB.COBOL(HELLOGB)").options("shr").report(true))
compile.dd(new DDStatement().name("SYSLIN").dsn("GOMATHI.DBB.OBJ(HELLOGB)").options("shr"))
compile.dd(new DDStatement().name("SYSUT1").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT2").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT3").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT4").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT5").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT6").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT7").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT8").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT9").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT10").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT11").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT12").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT13").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT14").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT15").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT16").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSUT17").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("SYSMDECK").options("cyl space(5,5) unit(vio) new"))
compile.dd(new DDStatement().name("TASKLIB").dsn("IGY630.SIGYCOMP").options("shr"))
compile.dd(new DDStatement().name("SYSPRINT").options("cyl space(5,5) unit(vio)  new"))
compile.copy(new CopyToHFS().ddName("SYSPRINT").file(new File("/u/ibmuser/gbdir/hellogb.log")))
def rc = compile.execute()

if (rc > 4)
    println("Compile failed!  RC=$rc")
else
    println("Compile successful!  RC=$rc")


def lked = new MVSExec().pgm("IEWL")                                    
                                                                        
lked.dd(new DDStatement().name("SYSPRINT").options("cyl space(5,5) unit(vio) new"))

                                                                        
lked.dd(new DDStatement().name("SYSUT1").options("cyl space(5,5) unit(vio) new"))
                                                                        
lked.dd(new DDStatement().name("SYSLIN").dsn("GOMATHI.DBB.OBJ(HELLOGB)").options("shr"))
                                                                        
lked.dd(new DDStatement().name("SYSLIB").dsn("CEE.SCEELKED").options("shr")) 
                                                                        
lked.dd(new DDStatement().dsn("CEE.SCEELKEX").options("shr"))           
                                                                        
lked.dd(new DDStatement().name("SYSLMOD").dsn("GOMATHI.DBB.LOAD(HELLOGB)").options("shr").output(true).deployType("LOAD"))
                                                                        
lked.copy(new CopyToHFS().ddName("SYSPRINT").file(new File("/u/ibmuser/gbdir/HELLOGB.lked.sysprint")))
                                                                        
def rc2 = lked.execute()                                                
                                                                        
if (rc2 > 4)                                                            
                                                                        
    println("lked failed!     RC=$rc2")   

else                                                                    
                                                                        
    println("lked successful!     RC=$rc2")    

println("Build report capturing in a file....") 
def buildReport = BuildReportFactory.getBuildReport()

def jsonOutputFile = new File("/u/ibmuser/gbdir/BuildReport.json")
def buildReportEncoding = "UTF-8"
buildReport.save(jsonOutputFile, buildReportEncoding)
