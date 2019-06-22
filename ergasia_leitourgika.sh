#!/bin/bash
clear

#Erwthma 1: Print file path names on files_found.txt"
echo ""
find ./task_1 -type f -fprint "files_found.txt"
echo "Printed file paths of task_1 on 'files_found.txt' file"

#Erwthma 2: Print current bash instance process ID"
echo ""
echo "Current bash instance ID:$$"
echo ""

#Erwthsh gia to megethos se KB tou erwthmatos 5b
echo "Enter value in KB for question 5b:"
read x

#Erwthma 3: Running 2 subshells
echo ""
echo "Starting 2 subshells:"
echo ""
(
#Erwthma 4: Subshell No1
echo "This is subshell number 1 running"
echo "Current bash instance ID:$$"
echo "Subshell number 1 ID:$BASHPID"
find ./task_1 -name "message_*" -fprint "message_x_files.txt"
cat message_x_files.txt | cut -d "_" -f 3 > output.txt
cat output.txt | cut -d "." -f 1 > output.txt
sort -n output.txt > sorted_output.txt #taksinomish tou output
mkdir temporary_folder

while read z #kanei mia prosorinh antigrafh twn arxeiwn message_x
do
cp ${z} temporary_folder
done < message_x_files.txt

while read y
do 
sed -n ${y}p ./temporary_folder/message_${y}.txt >> final_message.txt 
done < sorted_output.txt
)& 
(
#Erwthma 5: Subshell No2
echo "This is subshell number 2 running"
echo "Current bash instance ID:$$"
echo "Subshell number 2 ID:$BASHPID"
find ./task_1 -size +${x}k -fprint "files_size"
)&
wait
echo ""
echo "Subshells stopped running"
echo ""

#Erwthma 6: Ektupwsh toy arxeiou me tis grammes twn message_x 
while read t
do
  echo ${t}
done  < final_message.txt
echo ""

#Erwthma 7: Metakinish arxeiwn 
echo "Give a name for the folder in order to move files:"
read foldername
mkdir $foldername
while read f
do
  mv ${f} $foldername
done  < files_size
echo "Files over $x KB moved in '$foldername' folder"
echo ""

#Erwthma 8: Diagrafh proswrinwn arxeiwn
rm files_size
rm -rf temporary_folder
rm output.txt
rm sorted_output.txt
rm message_x_files.txt
echo "Temporary files deleted"


