document.getElementById('orderForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const apiUrl = document.getElementById('apiUrl').value;
    const drinkName = document.getElementById('drinkName').value;
    const ordererName = document.getElementById('ordererName').value;
    const customizations = document.getElementById('customizations').value;

    // 創建訂單的 JSON 請求
    const orderData = {
        drink: {
            name: drinkName
        },
        orderer: {
            name: ordererName
        },
        customizations: customizations,
        timestamp: new Date().toISOString()
    };

    try {
        // 發送 POST 請求到後端
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(orderData)
        });

        if (!response.ok) {
            throw new Error('無法提交訂單！請檢查後端服務。');
        }

        const newOrder = await response.json();

        // 更新前端表格顯示
        updateOrderTable(newOrder);

        // 清空表單
        document.getElementById('orderForm').reset();
    } catch (error) {
        alert(`提交失敗：${error.message}`);
    }
});

// 更新訂單表格
async function loadOrders() {
    const apiUrl = document.getElementById('apiUrl').value;

    try {
        // 發送 GET 請求到後端以獲取訂單記錄
        const response = await fetch(apiUrl);
        if (!response.ok) {
            throw new Error('無法加載訂單記錄！');
        }

        const orders = await response.json();

        // 清空現有表格
        const table = document.getElementById('orderTable').getElementsByTagName('tbody')[0];
        table.innerHTML = '';

        // 渲染訂單到表格
        orders.forEach(order => updateOrderTable(order));
    } catch (error) {
        alert(`加載訂單失敗：${error.message}`);
    }
}

function updateOrderTable(order) {
    const table = document.getElementById('orderTable').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    newRow.innerHTML = `
        <td>${order.drink.name}</td>
        <td>${order.orderer.name}</td>
        <td>${order.customizations}</td>
        <td>${new Date(order.timestamp).toLocaleString()}</td>
    `;
}

// 初始化時加載訂單
loadOrders();