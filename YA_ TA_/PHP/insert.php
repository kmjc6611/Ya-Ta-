<?php

    error_reporting(E_ALL);
    ini_set('display_errors',1);

    include('dbcon.php');


    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");


    if( (($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android )
    {

        $StudentID=$_POST['StudentID'];
        $Pwd=$_POST['Pwd'];
        $Name=$_POST['Name'];
        $Phone=$_POST['Phone'];
        $VehicleID=$_POST['VehicleID'];

        if(empty($StudentID)){
            $errMSG = "학번을 입력해 주시기를 바랍니다.";
        }
        else if(empty($Pwd)){
            $errMSG = "비밀번호를 입력해 주시기를 바랍니다.";
        }
        else if(empty($Name)){
            $errMSG = "이름을 입력해 주시기를 바랍니다.";
        }
        else if(empty($Phone)){
            $errMSG = "전화번호를 입력해 주시기를 바랍니다.";
        }
        else if(empty($VehicleID)){
            $errMSG = "차량번호를 입력해 주시기를 바랍니다.";
        }

        if(!isset($errMSG))

        {
            try{

                $stmt = $con->prepare('INSERT INTO person(StudentID, Pwd, Name, Phone, VehicleID) VALUES(:StudentID, :Pwd, :Name, :Phone, :VehicleID)');
                $stmt->bindParam(':StudentID', $StudentID);
                $stmt->bindParam(':Pwd', $Pwd);
                $stmt->bindParam(':Name', $Name);
                $stmt->bindParam(':Phone', $Phone);
                $stmt->bindParam(':VehicleID', $VehicleID);

                if($stmt->execute())
                {
                    $successMSG = "새로운 사용자를 추가했습니다.";
                }
                else
                {
                    $errMSG = "사용자 추가 에러";
                }

            } catch(PDOException $e) {
                die("Database error: " . $e->getMessage());
            }
        }

    }

?>


<?php
    if (isset($errMSG)) echo $errMSG;
    if (isset($successMSG)) echo $successMSG;


    if (!$android)
    {
?>
    <html>
       <body>

            <form action="<?php $_PHP_SELF ?>" method="POST">
                StudentID: <input type = "text" name = "StudentID" />
                Pwd: <input type = "text" name = "Pwd" />
                Name: <input type = "text" name = "Name" />
                Phone: <input type = "text" name = "Phone" />
                VehicleID: <input type = "text" name = "VehicleID" />
                <input type = "submit" name = "submit" />
            </form>

       </body>
    </html>

<?php
    }
?>
