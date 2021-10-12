for i in $(seq $(sed -n 1p file.txt | wc -w))
  do
    awk '{print $'''$i'''}' file.txt | xargs
  done