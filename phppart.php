<?php

if(isset($_GET['q']))
{
$url=$_GET['q'];
}
else
{
echo 'ERROR';
}
  /* http://ccnabaaps.hostingsiteforfree.com/folder/phppart.php?q=http://www.espncricinfo.com/india/content/player/253802.html */

$content = file_get_contents($url,false,$context);


//icon starts
$a=strpos($content, "ODIs</b></td>")+13;
$content=substr($content,$a);
$b=strpos($content,"</td>");
$matches=substr($content,23,$b-23);

$content=substr($content,$b);

//icon ends 

echo $matches;


$a=strpos($content, "ciPlayertextb")+13;
$content=substr($content,0,$a);


$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);




$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);


$a=strpos($content, "<td ")+13;
$content=substr($content,$a);



$b=strpos($content,"</td>");
$runs=substr($content,7,$b-7);
echo '<br>';
echo $runs;


$a=strpos($content, "<td")+13;
$content=substr($content,$a);
$a=strpos($content, "<td")+13;
$content=substr($content,$a);
$b=strpos($content,"</td>");
$batavg=substr($content,7,$b-7);
echo '<br>';
echo $batavg;


$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);


$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);

$b=strpos($content,"</td>");
$strikerate=substr($content,7,$b-7);
echo '<br>';
echo $strikerate;


$a=strpos($content, "ODIs</b></td>")+13;
$content=substr($content,$a);

$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);
$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);
$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);
$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);
$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);


$b=strpos($content,"</td>");
$wickets=substr($content,7,$b-7);
echo '<br>';
echo $wickets;

$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);
$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);
$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);



$b=strpos($content,"</td>");
$bowlavg=substr($content,7,$b-7);
echo '<br>';
echo $bowlavg;

$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);
$b=strpos($content,"</td>");
$economy=substr($content,7,$b-7);
echo '<br>';
echo $economy;

$a=strpos($content, "<td nowrap=")+13;
$content=substr($content,$a);
$b=strpos($content,"</td>");
$bowlsr=substr($content,7,$b-7);
echo '<br>';
echo $bowlsr;




?>