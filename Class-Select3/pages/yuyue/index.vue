<template>
	<view class="">
		<text style="margin-left: 40%; font-size: 30px;">{{classinfo1}}</text>
		<br />
		<text style="font-size: 20px;">{{classinfo2}}</text>--------
		<text style="font-size: 20px;">电脑{{classinfo3}}台</text>
		<br />
		<text style="font-size: 20px;">服务器{{classinfo4}}台</text>
		<br />
		<text>学号</text>
		<input type="text" v-model="txt">
		<text>人数</text>
		<input type="text" v-model="persons"/>
		<text>电脑台数</text>
		<input type="text" v-model="computers" />
		<text>使用时间</text>
		<view class="paymode">
			<select-lay class="seclectpaytype" :value="paytype" slabel="type" svalue="typeid" placeholder="请选择"
				:options="paymode" @selectitem="selectitem"></select-lay>
		</view>
		<br />
		<button @click="admit" style="width: 50%;margin-left: 30%;">确定</button>
	</view>
</template>

<script>
		import {post} from '../../request/index.js'
	export default {
		data() {
			return {
				paytype: '',  //选择区数据
				paymode: [{
					type: '一小时',
					typeid: 1
				}, {
					type: '两小时',
					typeid: 2
				},
				{
					type: '三小时',
					typeid: 3
				},{
					type: '四小时',
					typeid: 4
				},{
					type: '五小时',
					typeid: 5
				}],
				txt: '',
				num: null,
                tiemnow:0,
				timeS: 0,
				classinfo1: '',
				classinfo2: '',
				classinfo3: 0,
				classinfo4: 0,
                persons:null,
				computers:null
			}
		},
		onLoad(options) {
           
			this.classinfo1 = options.param1 //接收其他页面的值
			this.classinfo2 = options.param2
			this.classinfo3 = options.param3
			this.classinfo4 = options.param4
		},

		methods: {
			admit() {
					 this.tiemnow=Date.now()+this.timeS*1000*60*60  //获取n个小时后的时间戳
		        post('http://localhost:8083/insert/use/useclassroom',{  //向后端发送数据
					classid: this.classinfo1,
					sid:this.txt,
					persons:this.persons,
					computers:this.computers,
					overtime:this.tiemnow
					
				}).then(data=>{
				})
			   post('http://localhost:8083/yuyue/updaclass',{ //向后端发送数据改变班级的属性
				   usedemo:true,
				   id:this.classinfo1
			   }).then(data=>{
				  wx.switchTab({
				  	url:'/pages/calss/index'
				  })
			   })  

			},
			selectitem(index, item) {
				this.payChannelid = item.typeid; //选择区代码
                       this.timeS=this.payChannelid
				if (index >= 0) {
					this.paytype = this.paymode[index].typeid;
					
				} else {
					this.paytype = ""
				}
			}
		}
	}
</script>

<style scoped>
	input {
		border: 1px solid black;
		width: 50%;
	}
</style>