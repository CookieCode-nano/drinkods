這個專案是一個基於 **Spring Boot** 的飲料訂購系統，主要功能是管理飲料和訂單，並用 REST API 和前端頁面來進行操作。專案的主要功能和結構說明：
---
<!-- 未實現的功能：
### **專案功能**
**飲料/訂購人管理**
   - **新增**：可以常用項目到系統中，包含飲料名稱/訂購人名稱和預設的特製內容，用來快速點餐。
   - **查詢**：可以查詢常用項目
   - **更新**：可以更新常用項目
   - **刪除**：可以刪除常用項目。 -->

**訂單管理**
   - **新增訂單**：用戶可以提交訂單，包含飲料名稱、訂購人名稱和特製內容。
   - **查詢訂單**：可以查詢所有訂單，並顯示飲料名稱、訂購人名稱、特製內容和訂單時間。

**前端頁面**
   - **首頁 (`index.html`)**：提供新增訂單的表單和訂單記錄的表格，並透過 JavaScript 與後端 API 互動。
   - **錯誤頁面 (`erro.html`)**：當發生錯誤時顯示的頁面。

**後端 API**
   - 提供 RESTful API，讓前端或其他應用程式可以與系統互動。

---

### **專案結構**
- drinkods
  - **Controller**：處理 HTTP 請求的控制層。
    - `HomeController`：處理首頁的視圖請求。
    - `DrinkController`：處理飲料相關的 API 請求。
  - **Service**：業務邏輯層。
    - `DrinkService`：處理飲料的業務邏輯。
    - `OrderService` 和 `OrderServiceImpl`：處理訂單的業務邏輯。
  - **Repository**：資料庫操作層。
    - `DrinkRepository`：操作飲料資料表。
    - `OrderRepository`：操作訂單資料表。
    - `OrdererRepository`：操作訂購人資料表。
  - **Entity**：資料庫實體類別。
    - `Drink`：飲料實體。
    - `Orders`：訂單實體。
    - `Orderer`：訂購人實體。
  - **DTO**：資料傳輸物件，用於 API 請求和回應。
    - `OrderRequest`：用於新增訂單的請求資料。
    - `OrderResponse`：用於回應訂單資料。
- resources
  - **`application.properties`**：配置資料庫、Thymeleaf 模板引擎等。
  - **`templates/`**：存放前端頁面模板（`index.html` 和 erro.html）。

4. **資料庫結構**
   - `Drink` 表：存放飲料資訊。
   - `Orders` 表：存放訂單資訊，與 `Drink` 和 `Orderer` 表有關聯。
   - `Orderer` 表：存放訂購人資訊。

---

### **運作流程**
1. 用戶透過首頁提交訂單，前端會呼叫 `/api/order` API。
2. 後端接收請求，透過 `OrderService` 處理業務邏輯，並將訂單存入資料庫。
3. 用戶可以在首頁查看所有訂單記錄，前端會呼叫 `/api/orders` API 獲取資料。
<!-- 4. 飲料的管理功能則透過 `/api/drinks` 提供的 API 進行操作。 -->

