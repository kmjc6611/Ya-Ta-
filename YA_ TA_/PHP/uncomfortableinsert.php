<?php

    error_reporting(E_ALL);
    ini_set('display_errors',1);

    include('dbcon.php');


    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");


    if( (($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android )
    {

        $StudentID=$_POST['StudentID'];
        $uncomfortable=$_POST['uncomfortable'];

        if(empty($StudentID)){
            $errMSG = "학번을 입력해 주시기를 바랍니다.";
        }
        else if(empty($uncomfortable)){
            $errMSG = "경로를 입력해 주시기를 바랍니다.";
        }



        if(!isset($errMSG))

        {
            try{

                $stmt = $con->prepare('INSERT INTO uncomfortable(StudentID, uncomfortable) VALUES(:StudentID, :uncomfortable)');
                $stmt->bindParam(':StudentID', $StudentID);
                $stmt->bindParam(':uncomfortable', $uncomfortable);

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
                uncomfortable: <input type = "text" name = "uncomfortable" />
                <input type = "submit" name = "submit" />
            </form>

       </body>
    </html>

<?php
    }
?>
