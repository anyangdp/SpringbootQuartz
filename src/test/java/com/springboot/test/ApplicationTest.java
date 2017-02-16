package com.springboot.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.sq.Application;
import com.sq.domain.vo.CommonScheduler;

@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {
	
	@Autowired
	private  Scheduler scheduler;
	
	@Test
    public void test() throws Exception {

		/*scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .storeDurably(true)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startNow()
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        Thread.sleep(5000);*/
    }
	public List<CommonScheduler> queryMp() throws Exception {
		List<CommonScheduler> css = new ArrayList<>();
		
		CommonScheduler cs = new CommonScheduler();
		CronTriggerImpl trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 59 23 * * ?");
		trigger.setName("storageMonthStatistic_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("storageMonthStatistic");
		cs.setGroupName("saas_old_group");
		cs.setDes("库存报表定时任务");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 40 0 * * ?");
		trigger.setName("checkTimeOutTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("checkTimeOutTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("盘点超时结束任务");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 0 1 1 * ? *");
		trigger.setName("monthClear_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("deptStaffClearCurrAmtMonthTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("领用金额按月清零");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 10 1 1 1 ? *");
		trigger.setName("yearClear_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("deptStaffClearCurrAmtYearTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("领用金额按年清零");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 10 07 * * ?");
		trigger.setName("mndjkEdmTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("mndjkEdmTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("美年邮件活动");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 30 0 * * ?");
		trigger.setName("overdueTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("overdueTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("过期物品判定");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 59 23 L * ?");
		trigger.setName("periodMonthSettleTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("periodMonthSettleTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("账期月结");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("59 59 23 ? * SUN");
		trigger.setName("pointsWeekTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("pointsWeekTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("积分定时任务");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 10 9 * * ?");
		trigger.setName("shopTicketMailTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("shopTicketMailTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("定时优惠券邮件");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 0 9 * * ?");
		trigger.setName("userPaySum_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("userPaySum");
		cs.setGroupName("saas_old_group");
		cs.setDes("通知昨日订单支付金额");
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 0 5 * * ?");
		trigger.setName("userReaciveEmail_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("userReaciveEmail");
		cs.setGroupName("saas_old_group");
		cs.setDes("通知已收货订单");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 20 1 * * ?");
		trigger.setName("vipDateControlTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("vipDateControlTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("VIP功能时间控制");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 30 1 * * ?");
		trigger.setName("yhdGoodsQueryBatchTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("yhdGoodsQueryBatchTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("1号店商品跑批定时任务");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 30 2 * * ?");
		trigger.setName("yhdGoodStockBatchTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("yhdGoodStockBatchTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("1号店库存查询跑批任务");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 0 2 * * ?");
		trigger.setName("yhdReturnGoodsQueryBatchTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("yhdReturnGoodsQueryBatchTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("1号店退货商品查询跑批定时任务");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 0 3 * * ?");
		trigger.setName("yhdOrderStatusSyncBatchTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("yhdOrderStatusSyncBatchTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("1号店订单状态同步");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 20 3 * * ?");
		trigger.setName("yhdAccountCheckingTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("yhdAccountCheckingTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("1号店对账接口定时任务");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 0 4 * * ?");
		trigger.setName("yhdGoodsClassifyTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("yhdGoodsClassifyTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("商品分类同步更新任务");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 30 4 * * ?");
		trigger.setName("addIndexToSolrTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("addIndexToSolrTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("添加索引");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 10 06 * * ?");
		trigger.setName("addJdIndexTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("addJdIndexTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("京东商品索引");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 10 00 * * ?");
		trigger.setName("checkCompanyAccount_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("checkCompanyAccount");
		cs.setGroupName("saas_old_group");
		cs.setDes("账户检测");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("0 10 01 * * ?");
		trigger.setName("checkOverdueCompany_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("checkOverdueCompany");
		cs.setGroupName("saas_old_group");
		cs.setDes("公司检测");
		cs.setTriggers(trigger);
		css.add(cs);
		
		cs = new CommonScheduler();
		trigger = new CronTriggerImpl();
		trigger.setCronExpression("00 50 23 * * ?");
		trigger.setName("dayTakeApartOrderTask_trigger");
		trigger.setGroup("saas_old_group");
		cs.setJobName("dayTakeApartOrderTask");
		cs.setGroupName("saas_old_group");
		cs.setDes("京东拆单");
		cs.setTriggers(trigger);
		css.add(cs);
		
		return css;
	}
}
