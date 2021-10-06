# 論文繪圖介紹

資料夾中分為fig、globe_res兩個資料夾，分別代表繪製圖片的python程式跟計算global response time、resource、cpu utilization的java程式

## fig資料夾
主要分為3個程式，用來繪製our policy、static threshold policy、dynamic threshold policy的圖片
執行前需要先安裝python3 環境
### make_fig.ipynb
用來繪製 our policy的圖片，執行前需要修改tmp_path到檔案儲存資料夾，tmp_path不只在第二格出現，底下在繪製global資料圖片時也會出現，要記得修改
### threshold.ipynb
繪製static threshold policy的圖片，執行前需要修改tmp_path到檔案儲存資料夾，tmp_path不只在第二格出現，底下在繪製global資料圖片時也會出現，要記得修改
### dyna threshold.ipynb
繪製dynamic threshold policy的片，執行前需要修改tmp_path到檔案儲存資料夾，tmp_path不只在第二格出現，底下在繪製global資料圖片時也會出現，要記得修改
### make flow fig.ipynb
繪製workload的圖片，用在論文中

## globe_res
用來計算各個policy的global資料，裡面分3個資料夾，
1.cal_cost:計算各種policy的cost
2.our_policy:計算our policy的global response time、cpu utilization、resource use、tmax violation
3.threshold:計算static threshold 跟dynamic threshold的global response time、cpu utilization、resource use、tmax violation

### our policy
#### globe_use.java
計算global resource use，執行前需要將filename修改為當前的檔案位置
### total_resp.java
計算global response time、tmax violation，執行前需要將filename修改為當前的檔案位置
### total_use.java
計算global cpu utilization，執行前需要將filename修改為當前的檔案位置

### threshold
### glo_use.java
計算global cpu utilization，執行前需要將filename修改為當前的檔案位置
### global_resource.java
計算global resource use，執行前需要將filename修改為當前的檔案位置
### globe_res.java
計算global response time、tmax violation，執行前需要將filename修改為當前的檔案位置

### cal_cost
#### cal_cost.java
計算our policy的cost
#### cal_threshold_cost.java
利用static threshold跟dynamic threshold的資料，跟our policy的cost function計算cost，執行前需要將filename修改為當前的檔案位置
























