package sp.tx.com.javalib;

/**
 * 作者：zhouliang
 * 时间：2018/3/27:15:08
 * 邮箱：18510971680@163.com
 * 说明：
 */
public interface Constant {
    String SKIP_TO_EVENT_DETAILS_ID = "skip_to_event_details_id";
    String SKIP_TO_EVENT_DETAILS_DATE = "skip_to_event_details_date";
    String ADD_EVENT_YES = "yes";
    String ADD_EVENT_NO = "no";
    boolean EVENT_TYPE_TRUE = true;
    boolean EVENT_TYPE_FALSE = false;
    String ADD_EVENT_START_TIME = "add_event_start_time";
    /**
     * 事件提醒时间标记
     */
    int EVENT_REMIND_TIME_REQUEST_CODE = 11;
    String EVENT_REMIND_TIME_KEY = "event_remind_time_key";
    String EVENT_REMIND_TIME_KEY_IS_ALL_DAY = "event_remind_time_key_is_all_day";
    String EVENT_REMIND_TIME_VALUE = "event_remind_time_value";
    String EVENT_REMIND_TIME_VALUE_START = "开始时间";
    String EVENT_REMIND_CURRENT_EIGHT_ALL_DAY = "当天08:00";
    String EVENT_REMIND_TIME_VALUE_FIVE = "提前5分钟";
    String EVENT_REMIND_CURRENT_NINE_ALL_DAY = "当天09:00";
    String EVENT_REMIND_TIME_VALUE_TEN = "提前10分钟";
    String EVENT_REMIND_ONE_DAY_AGO_EIGHT_ALL_DAY = "一天前08:00";
    String EVENT_REMIND_TIME_VALUE_THIRTY = "提前30分钟";
    String EVENT_REMIND_ONE_DAY_AGO_NINE_ALL_DAY = "一天前09:00";
    String EVENT_REMIND_TIME_VALUE_ONE_DAY = "提前一天";
    String EVENT_REMIND_ONE_WEEK_AGO_EIGHT_ALL_DAY = "1周前08:00";

    /**
     * 事件提醒方式标记
     */
    int EVENT_REMIND_MODE_REQUEST_CODE = 22;
    String EVENT_REMIND_MODE_KEY = "event_remind_mode_key";
    String EVENT_REMIND_MODE_VALUE = "event_remind_mode_value";
    String EVENT_REMIND_MODE_VALUE_NOTICE = "BOT推送";
    String EVENT_REMIND_MODE_VALUE_SMS = "短信";
    String EVENT_REMIND_MODE_VALUE_EMAIL = "邮件";

    /**
     * 事件重复时间标记
     */
    int EVENT_REPEAT_TIME_REQUEST_CODE = 33;
    String EVENT_REPEAT_TIME_KEY = "event_repeat_time_key";
    String EVENT_REPEAT_TIME_VALUE_EVERY_DAY = "每日";
    String EVENT_REPEAT_TIME_VALUE_WEEKLY = "每周";
    String EVENT_REPEAT_TIME_VALUE_MONTHLY = "每月";
    String EVENT_REPEAT_TIME_VALUE_ANNUALLY = "每年";
    String EVENT_REPEAT_TIME_DEFAULT_HINT = "请选择重复方式";
    int DAY = 1;
    int WEEK = 7;
    int MONTH = 31;
    int YEAR = 365;

    /**
     * 事件重复结束标记
     */
    int EVENT_REPEAT_END_REQUEST_CODE = 44;
    String EVENT_REPEAT_END_KEY = "event_repeat_end_key";
    String EVENT_REPEAT_END_VALUE_NEVER = "永不结束";

    /**
     * 事件类型标记:日常、会议、培训活动及请求码
     */
    int EVENT_TYPE_REQUEST_CODE = 55;
    String EVENT_TYPE_KEY = "event_type_key";
    String EVENT_TYPE_KEY_VALUE_ALL = "all";

    /**
     * 时间格式定义
     */
    String TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH = "yyyy年MM月dd日 HH:mm";
    String TIME_FORMAT_TYPE_CONTAIN_YEAR_AND_MONTH_ALL_DAY = "yyyy年MM月dd日";
    String DELETE_REPEAT_EVENT_FORMAT_TIME = "yyyyMMdd";
    String TIME_FORMAT_TYPE_NO_CONTAIN_YEAR_AND_MONTH = "yyyy-MM-dd HH:mm";
    String TIME_FORMAT_TYPE_TIME = "MM月dd日 HH:mm";
    String TIME_FORMAT_TYPE = "yyyyMMdd HH:mm:ss";
    String START_TIME_PICKER = "2000-01-01 00:00";
    String STOP_TIME_PICKER = "2050-12-31 23:59";
    String HOME_EVENT_DETAILS_TIME = "yyyy-MM-dd HH:mm:ss";
    String HOME_EVENT_DETAILS_TIME_SHOW = "HH:mm";
    String EVENT_DETAILS_TIME_SHOW = "MM月dd日";

    /**
     * 首页跳转新增事件，事件详情跳转编辑事件定义
     */
    String SKIP_TO_CALENDAR_ADD_EVENT_KEY = "skip_to_calendar_add_event_key";
    String SKIP_TO_CALENDAR_ADD_EVENT_VALUE = "新增事件";
    String SKIP_TO_CALENDAR_EDIT_EVENT_VALUE = "编辑事件";
    String SKIP_TO_EDIT_EVENT_BEAN_VALUE = "skip_to_edit_event_bean_value";
    String SKIP_TO_CALENDAR_ADD_DATE_KEY = "skip_to_calendar_add_date_key";
    /**
     * 修改删除事件常量标记
     */
    String DELETE_REPEAT_EVENT = "delete";
    String MODIFY_REPEAT_EVENT = "modify";
    String EDIT_REPEAT_EVENT_KEY = "edit_repeat_event_key";
    String DELETE_REPEAT_EVENT_KEY = "delete_repeat_event_key";
    String DELETE_CURRENT = "current";
    String DELETE_CURRENT_FOLLOW = "current_future";
    String DELETE_ALL = "all";
    String SKIP_TO_EDIT_EVENT_KEY = "skip_to_edit_event_key";
    String EDIT_EVENT_HOME = "edit_event_home";
    String EDIT_EVENT_DETAILS = "edit_event_details";

    /**
     * 日程类型图标名称
     */
    String ICON_DAILY = "i-daily";
    String ICON_BAOXIAO = "i-f i-baoxiao";
    String ICON_HAMMER = "i-f i-hammer";
    String ICON_PEIXUN = "i-f i-peixun";
    String ICON_SHENGRI = "i-f i-shengri";
    String ICON_STUDY = "i-f i-study";
    String ICON_TUANJIAN = "i-f i-tuanjian";
    String ICON_VIPCLUB = "i-f i-vipclub";
    String ICON_WEIXIU = "i-f i-weixiu";
    String ICON_WENBEN = "i-f i-wenben";
    String ICON_XIHUAN = "i-f i-xihuan";
    String ICON_HUIYI = "i-huiyi";
    int ICON_NULL = -1;

    /**
     * 提醒和重复服务器对照表
     */
    String ON_EIGHT = "on_eight";
    String ON_NINE = "on_nine";
    String PRE_EIGHT = "pre_eight";
    String PRE_NINE = "pre_nine";
    String PRE_WEEK_EIGHT = "pre_week_eight";

    String ON_TIME = "on_time";
    String FIVE_MINUTES = "five_minutes";
    String TEN_MINUTES = "ten_minutes";
    String THIRTY_MINUTES = "thirty_minutes";
    String ONE_DAY = "one_day";

    String BOT = "bot";
    String SMS = "sms";
    String EMAIL = "email";

    String EVERYDAY = "everyday";
    String EVERYWEEK = "everyweek";
    String EVERYMONTH = "everymonth";
    String EVERYYEAR = "everyyear";

    String CURRENT_MONTH = "月";
    String CURRENT_DAY = "日";

}
