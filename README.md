# 課題 14-3: ファイル書き込み

### 課題の説明
snowdepth.csvには令和3年度積雪深観測値がCSV形式で記載されている。
このファイルを読んで、各地域ごとの積雪量の合計を記載したsummary.txtを書き出すProgE3.mainメソッドを作成しなさい。

- ファイル名はString型変数を定義して実行時引数として与えること
- snowdepth.csvの最初の3列は`年,月,日`を意味し、以降は各地の降雪量(cm)である。降雪量は次の順で記載されている。

`中央区,北区(太平),北区(あいの里),東区,白石区,厚別区,豊平区,清田区,南区(南31条西8丁目),南区(定山渓),西区(西野),西区(平和),手稲区
`

ヒント: `BufferedReader`クラスのreadLine()を使うと１行ずつ読み込むことができる
https://docs.oracle.com/javase/jp/8/docs/api/java/io/BufferedReader.html

```
// 使用例
BufferedReader br = new BufferedReader(new FileReader("filename.txt"));
String line = br.readLine();
```
（注）「snowdepth.csv」をプロジェクト unitE3 のフォルダにコピーしてください。ただし、BlueJではCSVファイルをアイコン表示できないので、エクスプローラーで確認しましょう。
### snowdepth.csv
```
2021,11,1,0,0,0,0,0,0,0,0,0,0,0,0,0
2021,11,2,0,0,0,0,0,0,0,0,0,0,0,0,0
2021,11,3,0,0,0,0,0,0,0,0,0,0,0,0,0
2021,11,4,0,0,0,0,0,0,0,0,0,0,0,0,0
2021,11,5,0,0,0,0,0,0,0,0,0,0,0,0,0
2021,11,6,0,0,0,0,0,0,0,0,0,0,0,0,0
2021,11,7,0,0,0,0,0,0,0,0,0,0,0,0,0
2021,11,8,0,0,0,0,0,0,0,0,0,0,0,0,0
...
```

### summary.txt
```
中央区, 5842
北区(太平), 8872
北区(あいの里), 7957
東区, 7380
白石区, 6542
厚別区, 7303
豊平区, 7540
清田区, 6888
南区(南31条西8丁目), 6148
南区(定山渓), 8307
西区(西野), 7203
西区(平和), 9496
手稲区, 7151
```

### Notes
- The JDK is installed on GitHub Actions machines, so you're also able to directly invoke `javac`, `java`, or any other CLI command included in the JDK. 
