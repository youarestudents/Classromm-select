<template>
	<view>
		<view class="flex-container">
			<view v-for="(item,index) in CmptData1" :key="index" class="flex-item"  >
				<view  @click="yuyue(CmptData1[index])" :style="{ backgroundColor: item.usedemo ? '#e86e30' : '', height: '100%' }" >{{item.id}} </view>
			</view>
		</view>
		<br />
		<view class="flex-container">
			<view v-for="(item,index) in CmptData2" :key="index" class="flex-item" >
				<view  @click="yuyue(CmptData2[index])" :style="{ backgroundColor: item.usedemo ? '#e86e30' : '', height: '100%' }" >{{item.id}} </view>
			</view>
		</view>
		<br />
		<view class="flex-container">
			<view v-for="(item,index) in CmptData3" :key="index" class="flex-item" >
				<view  @click="yuyue(CmptData3[index])" :style="{ backgroundColor: item.usedemo ? '#e86e30' : '', height: '100%' }"> {{item.id}} </view>
			</view>
		</view>
		<br />
	</view>
</template>

<script>
	import {
		get
	} from '../../request/index.js'
	export default {
		data() {
			return {
				CmptData: [],
				color:'background-color: blue;',
				CmptData1: [],
				CmptData2: [],
				CmptData3: [],	
				backg:'background-color:red;'
			}
		},
		onLoad() {
	
			get('http://localhost:8083/yuyue/classroom').then(response => { 
				console.log(response)
				for(var i=0;i<response.length;i++){ 
					//分别赋值给三个数组
				
					if(i<3){
						this.CmptData1.push(response[i])
					}else if(i>=3&&i<6){
						this.CmptData2.push(response[i])
						
					}else{
						this.CmptData3.push(response[i])
				
					}					
				}
				this.CmptData = response				
			})
            
		},
		onShow(){ //每次页面展示都刷新页面
			get('http://localhost:8083/yuyue/classroom').then(response => {
				for(var i=0;i<response.length;i++){ //分别赋值给三个数组
					if(i<3){
						this.CmptData1[i]=response[i]
					}else if(i>=3&&i<6){
						this.CmptData2[i-3]=response[i]
						
						
					}else{
						this.CmptData3[i-6]=response[i]
					
					}					
				}
				this.CmptData = response	
			
							
			})
		},
		// computed:{
		// 	getitemcolor:{  // 给已使用的view标签改变颜色和样式
		// 		if(item.usedemo==true){
		// 			return {background:'#e86e30',height:'100%' }
		// 			// console.log(item)
		// 		}
		// 	}
		// },
		methods: {
			yuyue(classinfo) {
               
				uni.navigateTo({
					url: "/pages/yuyue/index?param1=" + classinfo.id + '&param2=' + classinfo.classname + //向其他页面传值
						'&param3=' + classinfo.computers + '&param4=' + classinfo.service
						
				})
			},
		


		}
	}
</script>

<style scoped>
	.flex-container {
		display: -webkit-flex;
		display: flex;
		width: 100%;
		height: 100rpx;
		background-color: lightgrey;
        justify-content: space-between;
		color:white;
		margin-top: 5rpx;

	}

	.flex-item {
		text-align: center;
		background-color: #0b57d0;
	    width: 20%;
		height: 70rpx;
		margin: 10px;
	}
</style>