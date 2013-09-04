本サンプルの実行方法

1:
genSource.cmdバッチファイルを実行し、wsdlファイルからJavaのStubコードを生成します。
実行するとJavaMailが無いと警告を発しますが、本サンプルでは利用しないので問題ありません。

もしくはAntでbuild.xmlファイルを実行することで同様の動作を行います。
実行はバッチファイル、Antどちらか一方で問題ありません。

2:
com.foce.developer.sample.axis.Settingクラス内のユーザー名とパスワードを設定します。

3:
com.foce.developer.sample.axisパッケージ内の各クラスはmainメソッドを持つ実行可能クラスとなっています。
通常のJavaアプリケーションと同じように実行します。
